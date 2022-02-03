class myVector<E>{						//шаблонный класс
	private Object[] elements;			//массив
	private int capacity;				//емкость (максимальное допустимое число элементов)
	private int size;					//число элементов

	public myVector(){
		capacity = 10;					//емкость по умолчанию равна 10
		size = 0;
		elements = new Object[capacity];
	}

	public myVector(int capacity){		//overloaded constructor
		this.capacity = capacity;
		size = 0;
		elements = new Object[capacity];
	}

	public int size(){
		return size;
	}				//метод число элементов в векторе

	public int capacity(){
		return capacity;
	}		//метод емкость вектора

	private boolean rangeCheckForAdd(int index){	//проверка введенного index для метода добавления (можно добавлять элемент и в конец вектора, поэтому index>size)
		if(index<0 || index > size){
			System.out.println("Wrong index!");
			return false;
		}
		else
			return true;
	}
	
	private boolean rangeCheckForDelete(int index){	//проверка введенного index для метода удления (можно удалять и последний элемент, поэтому index>=size)
		if(index<0 || index >= size){
			System.out.println("Wrong index!");
			return false;
		}
		else
			return true;
	}

	private void ensureSize(){								//расширение массива (вектора)
		if(size == capacity){
			Object[] tempArray = new Object[size];
			for(int i=0; i<size; i++)
				tempArray[i] = elements[i];
			capacity = 2*capacity + 10;
			elements = new Object[capacity];
			for(int i=0; i<tempArray.length; i++)
                		elements[i] = tempArray[i];
		}
	}

    	public void add(E el) {							//добавить элемент в конец
        	ensureSize();
        	elements[size] = el;
        	size++;
    	}

	public void add(int index, E el){					//добавить элемент по индексу
		if (rangeCheckForAdd(index)){
			ensureSize();
			for(int i=size; i>index; i--)				//сдвигаем
            			elements[i] = elements[i-1];
			elements[index] = el;
			size++;
		}
	}

	public void remove(int index){						//удалить элемент по индексу
		if(rangeCheckForDelete(index)){
			for(int i=index+1; i<size; i++)				//сдвигаем
            			elements[i-1] = elements[i];
			elements[(size-1)] = null;
			size--;
		}
	}

	public void removeLast(){							//удалить элемент по индексу
		if(size()==0)
			return;
		else{
			elements[(size-1)] = null;
			size--;
		}
	}

	public void clear(){								//удалить все элементы
		for(int i=0; i<size; i++)
			elements[i] = null;
		size = 0;
	}

    	public void print(){							//распечатать массив
			if (size == 0)
				System.out.println("[]");
			if (size == 1)
				System.out.println("[" + elements[0] + "]");
			if (size > 1) {
				System.out.print("[");
				for (int i = 0; i < size - 1; i++)
					System.out.print(elements[i] + " , ");
				System.out.print(elements[size - 1] + " ]");
				System.out.println();
			}
		}
}
