package groupbase.thn.web.libs;


public abstract class ModelBase {
	protected JDOModel jdoModel = new  JDOModel();
	public ModelBase(){
		
	}
	public abstract View init();
}
