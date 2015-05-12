"Well done for breaking the code down into packages. Although not part of the specification it makes assessing the work easier.
It would be helpful to include a README.md file describing the content of the repository.
Considering each of the eight points in turn:
1)  Just use the boolean type
@Override public boolean hasError() { if (errorMsg == ErrorMessage.NO_ERROR) return false; return true; }
return errorMsg == ErrorMessage.NO_ERROR
inline if ?: 
@Override public Object getReturnValue() { if (hasError()) return null; return rtnObj; }
2) As above
@Override public boolean isEmpty() { if (list[0] == null) return true; return false; }
Could this be more concise?
private ReturnObject testBound(int index) { if (size() == 0) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); if (index + 1 &gt; size() || index &lt; 0) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); return new ReturnObjectImpl(ErrorMessage.NO_ERROR); }
3) As above
@Override public boolean isEmpty() { if (value == null) return true; return false; }
4) Inline if and temporary variable?
@Override public ReturnObject head() { if (isEmpty()) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); return new ReturnObjectImpl(get(0).getReturnValue()); }
5) Good.
6) Try and avoid magic numbers
int i=0; while (!get(i).hasError()) { listSample.add(get(i).getReturnValue()); i += 2; }
7) Could this have been more concise?
@Override public void push(Object item) { //CW spec says null item does not need to be dealt with, and therefore no checks are made here if (internalList.isEmpty()) internalList.add(item); else internalList.add(0,item);  }
8) Very good.
 
Well done.
 
 "
