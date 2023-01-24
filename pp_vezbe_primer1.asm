Pre funkcije
push	a
push	head
call	count

Stek
BP, SP ->	staro BP
BP+2		IP
BP+4		head
BP+6		a

Funkcija
push	bp
mov		bp, sp

mov		ax, [bp+6]
push	ax
mov		ax, [bp+4]
push	ax
call	find
add		sp, 4


mov		ax, s
add		ax, cx
mov		s,  ax

mov		sp, bp
pop		bp
ret

Funkcija find

SP   	-> res
BP   	-> staro BP
BP+2 	-> IP	
BP+4 	-> l
BP+6	-> x

l	-> 	info
l+2	-> 	next

push	bp
mov		bp, sp

sub		sp, 2

					; if (l == 0)
mov		ax, [bp+4]
test	ax, ax		; if (l == 0)
jnz		lab1
mov		[bp-2], 0
jmp		kraj


lab1:				; if (l->info == x)
mov		bx, [bp+4]  ; l
mov		ax, [bx]	; l->info
mov		cx, [bp+6]	; x
cmp		ax, [bp+6]  ; if (l->info == x)
jne		lab2
mov		[bp-2], 1
jmp		kraj

lab2				; else
mov		ax, [bx+2]	; l->next
push	cx			; x
push	ax			; l->next
call	find		; rezultat u cx
sub		sp, 4
mov		[bp-2], cx

kraj:
mov		cx, [bp-2]
mov		sp, bp
pop		bp

