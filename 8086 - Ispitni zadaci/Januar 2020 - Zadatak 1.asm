push	vr
call	verify_preconditions

verify_preconditions:
Stek:
        result		bp+6
        *vr			bp+4
        IP			bp+2
BP ->	staro BP	
        truth		bp-2
SP ->	condition	bp-4

vr:
        type		[vr]
        *next		[vr+2]
        query_id	[vr+4]

Procedura:
push	bp
mov 	bp,	sp

sub		sp, 4

mov		[bp-2], 0 	; truth = 0
mov		[bp-4], 1	; condition = 1

mov 	bx, [bp+4] 	; adr of(vr)

mov		ax, [bx]
test	ax, ax
jnz		lab1

mov		ax, [bx+4]
push	ax
call	exec_query
add		sp, 2

mov		ax, [bp-4] 	; ax = condition
mul		cx			; dx:ax = condition * cx
mov		[bp-4], ax	; condition = ax


lab1:
mov		ax, [bx+2]
test	ax, ax
jz		kraj

push	ax
push	ax
call	verify_preconditions
add		sp, 2

pop		cx 			; ax = result<verify_preconditions>
mov		ax, [bp-4]	; ax = condition
mul		cx			; dx:ax = condition * cx
mov		[bp-4], ax	; condition = ax

kraj:
mov		[bp+6], ax	; result = ax
mov		sp, bp
pop		bp
ret