package example.sr.fyp;

public class plant_add {
    String pid;
    String pname;
    String pspecie;
    String pfamily;
    String plocation;
    public plant_add(){
    }

    public plant_add(String pid, String pname, String pspecie, String plocation ,String pfamily){
        pid=pid;
        pname=pname;
        pspecie=pspecie;
        plocation=plocation;
        pfamily=pfamily;

    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getPspecie() {
        return pspecie;
    }

    public String getPlocation() {
        return plocation;
    }
    public String getPfamily() {
        return pfamily;
    }
}


