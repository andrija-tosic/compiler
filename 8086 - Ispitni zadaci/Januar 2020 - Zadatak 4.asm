struct model:
id		[m]
type	[m+2]
*next	[m+4]

render_scene stek:
        *m			[bp+4]
        IP			[bp+2]
BP ->	staro BP
SP ->	loaded		[bp+6]

push	bp
mov		bp, sp

sub		sp, 2		; za loaded

mov		[bp+6], 0
mov		ax, [bp+6]  ; ax = loaded

mov		bx, [bp+4]
mov		cx, [bx+2]	; cx = m->type
push	cx
mov		cx, [bx]	; cx = m->id
push	cx
call	load_model
sub		sp, 4

pop		cx			; cx = load_model()
add		ax, cx		; ax = loaded + load_model()

mov		[bp+6], ax	; loaded = ax

mov		cx, [bx+4]  ; cx = m->next
test	cx, cx
jz		lab1

push	cx
call	render_scene

add		ax, cx		; ax += render_scene()

lab1:
mov		cx, ax		; result = cx

mov		sp, bp
pop		bp
ret
