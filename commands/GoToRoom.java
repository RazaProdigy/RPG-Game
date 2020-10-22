package commands;

import characters.Alisson;
import scenes.Forest;
import scenes.Hospital;

public class GoToRoom implements Command{

    Hospital hospital;
    Alisson a;
    public GoToRoom(Hospital h, Alisson a)
    {
        hospital = h;
        this.a = a;
    }

    @Override
    public void execute() {
        hospital.nextScene(a);
        a.setCmdDone(true);
    }
}