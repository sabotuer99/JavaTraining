package contracts;

import java.sql.ResultSet;

public interface IResultProcessor {
	Object process (ResultSet rs, Object result) throws Exception;
}
