package util;

public class Pair<T1, T2> {
  private final T1 first;
  private final T2 second;
  
  public Pair(T1 first, T2 second){
    super();
    this.first = first;
    this.second = second;
  }
  
  public T1 fst() {return this.first;}

  public T2 snd() {return this.second;}

}
  
