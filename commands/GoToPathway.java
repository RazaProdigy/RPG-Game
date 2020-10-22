package commands;

import characters.Alisson;
import scenes.Forest;

public class GoToPathway implements Command{

    Forest forest;
    Alisson a;
    public GoToPathway(Forest f, Alisson a)
    {
        forest = f;
        this.a = a;
    }

    @Override
    public void execute() {
        forest.nextScene(a);
        a.setCmdDone(true);
    }
}
