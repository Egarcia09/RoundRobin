
public class ProcessCreation
{
    int id;
    int at;
    int bt;
    int cs;
    
    public ProcessCreation(int id, int at, int bt,int cs)
    {
        this.id = id;
        this.at = at;
        this.bt = bt;
        this.cs = cs;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setAt(int at)
    {
        this.at = at;
    }

    public int getAt()
    {
        return at;
    }

    public void setBt(int bt)
    {
        this.bt = bt;
    }

    public int getBt()
    {
        return bt;
    }

    public void setCs(int cs)
    {
        this.cs = cs;
    }

    public int getCs()
    {
        return cs;
    }
}

