//Report average age of children
//Report percentage vaccinated

import java.util.*;

public class Vaccination {
	
	public static final int MAX_CHILDREN = 666;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Child> children = new ArrayList<Child>();

		System.out.print("Number of children: ");
		int numChi = sc.nextInt();
		sc.nextLine();
		System.out.println("Number of children is " + numChi);

		String name;
		int age;
		boolean vaccinated;
		for(int i=0; i<numChi; i++) {
			children.add(new Child());

			System.out.print("Name: ");
			name = sc.nextLine();
			children.get(i).setName(name);
			children.get(i).printName();

			System.out.print("Age: ");
			age = sc.nextInt();
			sc.nextLine();
			children.get(i).setAge(age);
			children.get(i).printAge();

			System.out.print("Vaccinated for chickenpox? ");
			vaccinated = sc.nextBoolean();
			sc.nextLine();
			children.get(i).Vaccinate(vaccinated);
			children.get(i).printVStatus();
		}
		double avgAge = Child.averageAge(children);
		System.out.printf("Average age is %.2f", avgAge);
		System.out.println();
		double perVac = Child.percentageVaccinated(children);
		System.out.printf("Percentage of children vaccinated is %.2f%%", perVac);
		System.out.println();
	}

	public static class Child {
		private String name;
		private String firstName;
		private String lastName;
		private String middleName;
		private int age;
		private boolean vaccinated;

		public Child() {
			name = "";
			firstName = "";
			lastName = "";
			middleName = "";
			age = 666;
			vaccinated = false;
		}

		public Child(String n, int a, boolean v) {
			name = n;
			//printName();
			String[] fullName = name.split("\\s+");
			if(fullName.length == 1) {
				firstName = fullName[0];
				middleName = "";
				lastName = "";
			}
			else if(fullName.length == 2) {
				firstName = fullName[0];
				lastName = fullName[1];
				middleName = "";
			}
			else {
				firstName = fullName[0];
				middleName = fullName[1];
				for(int i=2; i<(fullName.length-1); i++) {
					middleName = middleName.concat(fullName[i]);
					if(i != fullName.length-2) {
						middleName = middleName.concat("-");
					}
				}
				System.out.println(middleName);
				lastName = fullName[fullName.length-1];
			}
			age = a;
			//printAge();
			vaccinated = v;
			//printVStatus();
		}

		public void setName(String n) {
			name = n;
			String[] fullName = name.split("\\s+");
			if(fullName.length == 1) {
				firstName = fullName[0];
				middleName = "";
				lastName = "";
			}
			else if(fullName.length == 2) {
				firstName = fullName[0];
				lastName = fullName[1];
				middleName = "";
			}
			else {
				firstName = fullName[0];
				middleName = fullName[1];
				for(int i=2; i<(fullName.length-1); i++) {
					middleName = middleName.concat(fullName[i]);
					if(i != fullName.length-2) {
						middleName = middleName.concat("-");
					}
				}
				lastName = fullName[fullName.length-1];
			}

		}

		public void printName() {
			System.out.println("Name is \"" + this.name + "\"");
		}

		public void printAge() {
			System.out.println("Age is " + this.age);
		}

		public void printVStatus() {
			if(this.vaccinated == true)
				System.out.println("Vaccinated for chickenpox");
			else
				System.out.println("Not vaccinated for chickenpox");
		}

		public void setAge(int a) {
			age = a;
		}

		public void Vaccinate(boolean v) {
			vaccinated = v;
		}

		public static double averageAge(ArrayList<Child> arr) {
			int sum = 0;
			for(int i=0; i<arr.size(); i++) {
				sum += arr.get(i).age;
			}
			return (sum*1.0)/arr.size();
		}

		public static double percentageVaccinated(ArrayList<Child> arr) {
			double numVaccinated = 0;
			for(int i=0; i<arr.size(); i++) {
				if(arr.get(i).vaccinated == true) {
					numVaccinated++;
				}
			}
			return (numVaccinated/arr.size())*100.0;
		}
	}
}
