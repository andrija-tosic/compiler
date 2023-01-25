(8 poena) Definisati 8086 kod i izgled aktivacionog sloga za funkciju find_delivery. Za predstavljanje
podataka tipa int kao i memorijskih adresa koriste se 2 bajta. Pretpostaviti da se rezultat funkcije
calculate_distance (koji je tipa int) vraća kroz registar CX, dok se rezultat funkcije find_delivery
smešta na stek.
struct delivery
{
 int has_car;
 int longitude;
 int latitude;
 int is_busy;
 struct delivery *next;
};
int find_delivery(struct delivery* person, int max_distance,
 int rest_long, int rest_lat)
{
 int distance;    
 int count = 0;
 if(person->is_busy == 0)
 {
 distance = calculate_distance(person->longitude, person→latitude,
 rest_long, rest_lat) * (2 – person->has_car);
 if (distance < max_distance)
 count += 1;
 }
 if (person->next != 0)
 return count + find_delivery(person->next, max_distance,
 rest_long, rest_lat);
 return count;
}


struct delivery:
has_car     [person]
longitude   [person+2]
latitude    [person+4]
is_busy     [person+6]
*next       [person+8]

find_delivery stek:
            result          [bp+12]
            rest_lat        [bp+10]
            rest_long       [bp+8]
            max_distance    [bp+6]
            *person         [bp+4]
            IP              [bp+2]
BP ->       staro BP        [bp]
            distance        [bp-2]
SP ->       count           [bp-4]

funkcija:
push        bp
mov         bp, sp

sub         sp, 4                ; za distance i count
mov         [bp-4], 0

mov         bx, [bp+4]           ; bx = *person
mov         ax, [bx+6]           ; ax = person->is_busy

test        ax, ax
jnz         lab1

mov         cx, [bp+10]           ; cx = rest_lat
push        cx
mov         cx, [bp+8]            ; cx = rest_long
push        cx
mov         cx, [bx+4]            ; cx = person->latitude
push        cx
mov         cx, [bx+2]            ; cx = person->longitude
call        calculate_distance    ; rezultat u cx
mov         ax, cx                ; ax = calculate_distance()
sal         cx, 1                 ; cx = calculate_distance()*2
mov         dx, [bx]              ; dx = person->has_car
 
mul         dx                    ; dx:ax = calculate_distance()*person->has_car
sub         cx, ax                ; cx = calculate_distance()*2 - calculate_distance()*person->has_car
 
mov         [bp-2], cx            ; distance = cx
cmp         cx, [bp+6]            ; distance < max_distance
jge         lab2

inc         [bp-4]

lab2:
lab1:

cmp       [bx+8], 0              ; person->next != 0
je        lab3

push       ax                    ; za rezultat
mov        cx, [bp+10]           ; cx = rest_lat
push       cx
mov        cx, [bp+8]            ; cx = rest_long
push       cx
mov        cx, [bp+6]            ; cx = max_distance
push       cx
mov        cx, [bx+8]            ; cx = person->next
push       cx
call       find_delivery
pop        cx                    ; rezultat = cx
add        cx, [bp-4]            ; cx += count

mov        sp, bp
pop        bp
ret

lab3:
mov        cx, [bp-4]            ; cx = count

mov        sp, bp
pop        bp
ret
