package Scales;


public class ScaleExample {
	public static void main(String[] args) {
		
		int [] majorIntervals = {2,2,1,2,2,2,1};

		Scale.Template major = new Scale.Template(majorIntervals);

		Scale DbMajor = Scale.createScaleByTemplate(major, 1);

		System.out.println("Db Major: " + DbMajor);
	}
}

