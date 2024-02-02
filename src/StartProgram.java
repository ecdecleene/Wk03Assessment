import java.util.List;
import java.util.Scanner;

import controller.UniformHelper;
import model.PlayerUniform;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static UniformHelper lih = new UniformHelper();

	private static void addUniform() {
		// TODO Auto-generated method stub
		System.out.print("Enter a number: ");
		String store = in.nextLine();
		System.out.print("Enter an name: ");
		String item = in.nextLine();
		PlayerUniform toAdd = new PlayerUniform(store, item);
		lih.insertUniform(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the number to delete: ");
		String store = in.nextLine();
		System.out.print("Enter the name to delete: ");
		String item = in.nextLine();
		PlayerUniform toDelete = new PlayerUniform(store, item);
		lih.deleteUniform(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Number");
		System.out.println("2 : Search by Name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<PlayerUniform> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the uniform number: ");
			String numberN = in.nextLine();
			foundItems = lih.searchForUniformByNumber(numberN);
		} else {
			System.out.print("Enter the uniform name: ");
			String nameN = in.nextLine();
			foundItems = lih.searchForUniformByName(nameN);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (PlayerUniform l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			PlayerUniform toEdit = lih.searchForUniformById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getNumber());
			System.out.println("1 : Update Number");
			System.out.println("2 : Update Name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Number: ");
				String newStore = in.nextLine();
				toEdit.setNumber(newStore);
			} else if (update == 2) {
				System.out.print("New Name: ");
				String newItem = in.nextLine();
				toEdit.setName(newItem);
			}

			lih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Uniform List ---");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add a uniform");
			System.out.println("*  2 -- Edit a uniform");
			System.out.println("*  3 -- Delete a uniform");
			System.out.println("*  4 -- View the uniform list");
			System.out.println("*  5 -- Exit");
			System.out.print("*  What would you like to do?: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addUniform();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheUniforms();
			} else {
				lih.cleanUp();
				System.out.println("   Exited   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheUniforms() {
		// TODO Auto-generated method stub
		List<PlayerUniform> allUniforms= lih.showUniforms();
		for (PlayerUniform singleUniform : allUniforms) {
			System.out.println(singleUniform.returnItemDetails());
		}

	}
}