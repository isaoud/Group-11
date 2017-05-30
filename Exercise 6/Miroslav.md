##Ex: 6.1
```
q:= insert(2,insert(4,new))
min(insert(4,new)) = 4
2<4  = delete_min(insert(2,insert(4,new)))=insert(4,new)
delete_min(insert(4,new)) = new
```


##Ex:6.2
```
Type Option [T]
Functions: 
none: Option[T] -> zero
some(t): Option[T] -> t
the: Option[T] -> t 	//selector

Preconditions: -

Axioms: t : T, t •
none(option(t)) = zero
some(t)(option(t)) = t
this(some(t)(option(y))) = t
```
