import java.util.Properties;

public abstract class AbstractGenUrl implements IGenUrl 
{
	protected Properties prop;

	public void setProp(Properties prop) 
	{
		this.prop = prop;
	}
	
}
