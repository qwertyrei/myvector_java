//Операционная система: Ubuntu 18.04
//Код пишется в: IntelliJ IDEA
//openjdk-17.0.1

import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {										//try catch если пользователь введет не int ch
			int ch;									//choice
			int size;								//число элементов
			int capacity;							//вместимсоть (максимальное допустимое число элементов)
			String el;
			int index;
			myVector<String> v;
			Scanner s1 = new Scanner(System.in);	//четыре сканнера для корректного считывания элементов
			System.out.println("Do you want to change capacity?");
			System.out.println("Enter 1 to use default capacity");
			System.out.println("Enter any integer but 1 to change capacity");
			ch = s1.nextInt();
			if (ch == 1)
				v = new myVector<>();
			else {
				System.out.println("Enter capacity:");
				capacity = s1.nextInt();
				v = new myVector<>(capacity);
			}
			System.out.println("Нажмите:");
			System.out.println("1, если хотите добавить  элемент в конец вектора;");
			System.out.println("2, если хотите удалить последний элемент;");
			System.out.println("3, если хотите удалить элемент по индексу;");
			System.out.println("4, если хотите вставить элемент по индексу;");
			System.out.println("5, если хотите удалить все элементы (очистить вектор);");
			System.out.println("6, если хотите узнать, сколько элементов сейчас в векторе;");
			System.out.println("7, если хотите узнать емкость вектора на данный момент;");
			System.out.println("8, если хотите вывести вектор на экран;");
			System.out.println("9, если хотите выйти;");
			while (true) {
				Scanner s2 = new Scanner(System.in);
				System.out.println("Enter ch");
				ch = s2.nextInt();
				if (ch == 1) {
					System.out.println("Enter el");
					Scanner s3 = new Scanner(System.in);
					el = s3.nextLine();
					v.add(el);
				} else if (ch == 2) {
					v.removeLast();
				} else if (ch == 3) {
					System.out.println("Enter index");
					index = s2.nextInt();
					v.remove(index);
				} else if (ch == 4) {
					System.out.println("Enter index");
					index = s2.nextInt();
					System.out.println("Enter el");
					Scanner s4 = new Scanner(System.in);
					el = s4.nextLine();
					v.add(index, el);
				} else if (ch == 5) {
					v.clear();
				} else if (ch == 6) {
					System.out.println("Size:\t" + v.size());
				} else if (ch == 7) {
					System.out.println("Capacity:\t" + v.capacity());
				} else if (ch == 8) {
					v.print();
				} else System.exit(0);
			}
		}
		catch (Exception InputMismatchException){		//если пользователь ввел не int ch, то программа заканчивает свою работу
			System.out.println ("Wrong enter!");
			System.exit(0);
		}
	}
}
