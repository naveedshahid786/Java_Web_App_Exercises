package JdbcExercises;

public class StudentInsertProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			StudentDAO dao = new StudentDAO();
			dao.insertStudent();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
