package observables;

public interface SubjectPoints {
    
    public void addObserver(ObserverPoints o);
    public void removeObserver(ObserverPoints o);
    public void notifyObserver();
}