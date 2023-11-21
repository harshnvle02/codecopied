
package anuspos;


public class TableRow 
{
    int index ,add;
    String symbol;
    
    public TableRow(String s,int a, int i)
    {
        symbol=s;
        add=a;
        index=i;
        
    }
    public String getsymbol()
    {
        return symbol;
        
    }
    public void setsymbol(String s)
    {
        symbol=s;
    }
    
    public Integer getaddress()
    {
        return add;
    }
    
    public void setaddress(Integer a)
    {
        add=a;
    }
    
    public Integer getIndex()
    {
        return index;
        
    }
    public void setindex(Integer i)
    {
        index=i;
    }
}
