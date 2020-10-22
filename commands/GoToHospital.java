package commands;

import characters.Alisson;
import scenes.Forest;
import scenes.Pathway;

public class GoToHospital implements Command{

    Pathway pathway;
    Alisson a;
    public GoToHospital(Pathway p, Alisson a)
    {
        pathway = p;
        this.a = a;
    }

    @Override
    public void execute() {
        pathway.nextScene(a);
        a.setCmdDone(true);
    }
}