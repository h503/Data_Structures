public class Linked_List<E> 
	{
		private class Node 
		{
			E data; 
			Node next;
			
			/* Creating constructor to allow us to instantiate nodes */
			private Node(E data)
			{
				this.data = data;
			}
		}
		
		/* Explicitly initializing head to null */
		Node head = null; 
		
	/* Linked List Methods */
		
		boolean add(E e)
		{
			/* The list is empty */
			if (head == null)
			{
				/* Creating a new Node */
				head = new Node(e);
			}
			else
			{
				/* The list is not empty */
				
				/* Assign a current to head */
				Node curr = head;
				
				/* Iterating over the list */
				while(curr.next != null)
				{
					curr = curr.next;
				}
				
				/* Add a new node to the end of the list */
				curr.next = new Node(e);
				/* We've successfully added a new node */
				return true;	
			}
			/* For some reason we were unsuccessful in adding to the end of the list */
			return false;	
		}
		
		void add(int index, E element)
		{
			Node curr = head;
			Node prev = null;
			Node newNode = null;
			int counter = 0;
			
			/* Iterating through the list to the position we want */
			while(curr != null && counter != index)
			{
				prev = curr;
				curr = curr.next;
				counter++;
			}
		
			/* Now counter == index */ 
			
			/* We are at the head of the list */
			if(counter == 0)
			{
				/* Adding this element to the front of the list */
				curr = new Node(element);
				curr.next = head;
				head = curr;
			}
			else
			{
				/* Adding to the end of the list */
				newNode = new Node(element);
				prev.next = newNode;
				newNode.next = curr;
			}
		}	
						
		/*
			Node curr = head;
			int counter = 0;
			
			 /* Traversing the entire list */
		//	while(curr.next != null)
		//	{
				/* We are at the head of the list */
		//		if(counter == index)
			//	{
			//		curr = new Node(element);
			//		curr.next = head;
			//	}
				/* We are not at the end but either in the middle or end */
			//	else if(counter > 0)
			//	{
					/* Adding to the middle of the linked list */
					
			//	}
		//	}			
	//	}
		
		boolean contains(Object o)
		{
			/* Assigning curr to be the head of the list */
			Node curr = head; 
			
			/* Iterating throughout the list */
			while(curr != null) 
			{
				if(o.equals(curr.data))
				{
					return true;
				}
				
				/* Moving over to the next node */
				curr = curr.next;
			}
			/* Didn't find it in the list */ 
			return false;
		}
		
		/* Returns the element at the specified position in this list */
		public E get(int index)
		{
			Node curr = head;
			int counter = 0;
			
			/* Checking if counter and index match */
				/* Traversing the list */
				while(curr.next != null)
				{
					if(counter != index)
					{
						/* Moving over to the next node */
						curr = curr.next;
						counter++;
					}
					else
					{
						/* Counter equals Index */
						return curr.data;
					}
				} 

			/* Returning data at that index */
			return curr.data;
		}
		
		/* Inserts the specified element at the beginning of the list */
		public void addFirst(E e)
		{
			Node curr = head; 
			
			/* Checking if we are at the head of the list */
			if (curr == head)
			{
				curr = new Node(e);
				curr.next = head;
				head = curr;
			}
		}
		
		/* Inserts the specified element at the end of the list */
		public void addLast(E e)
		{
			Node curr = head;
			
			/* Iterating through the list */
			while (curr.next != null)
			{
				curr = curr.next;
			}
			
			/* Loop ends when we are at the end of the list */
			curr.next = new Node(e);
		}
		
		/* Returns the number of elements in the list */
		public int size()
		{
			Node curr = head;
			int counter = 0;
			
			while(curr != null)
			{
				curr = curr.next;
				counter++;
			}
			
			return counter;
		}
		
		/* Removes the first occurrence of the specified element from this list */
		public boolean remove(Object o)
		{			
			Node curr = head; 
			Node prev = null;
			
			while(curr != null)
			{
				if(o.equals(curr.data))
				{
					/* We are at the head of the list */
					if(curr == head)
					{
						head = head.next;
					}
					
					/* We are at the middle of the list */
					else if (prev.next != null)
					{
						prev.next = curr.next;
					}	
				}
				
				/* Continue traversing the list */
				prev = curr;
				curr = curr.next;
			}
			return true;
		}
		
		/* Removes the element at the specified position in this list */
		public E remove(int index)
		{
			Node curr = head;
			Node prev = null;
			int counter = 0;
			E element = null;
			
			while(curr != null)
			{
				if (counter == index)
				{
					/* We are at the head of the list */
					if(curr == head)
					{
						element = curr.data;
						head = head.next;
					}
					/* We are at the middle of the list */
					else if (prev.next != null)
					{
						element = curr.data;
						prev.next = curr.next;
					}
				}
				
				/* Continue traversing the list */
				prev = curr;
				curr = curr.next; 
				counter++;
			}
			
			return element; 
		}
		
		/* Replaces the element in the specified position in this list with the 
		 * specified element
		 */
		public E set(int index, E element)
		{
			Node curr = head; 
			int counter = 0;
			
			while (curr != null)
			{
				if(counter == index)
				{
					/* Changing the data */
					curr.data = element;
				}
				
				curr = curr.next;
				counter++;
			}
			return element;
		}
		
		/* Removes all the elements from the list. The list will be empty after this 
		 * call returns 
		 */
		public void clear()
		{
			head = null;
		}	

	public static void main(String[] args) 
	{
		/* Testing Linked List */ 
		Linked_List<String> list = new Linked_List<String>();
		
		/* This verifies that the "Boolean add(E e)" method works as well as the 
		 * get(int index) method */
		System.out.println("Testing Method #0");
		list.add("Billy Bob");
		list.add("Johnny Rocketts");
		list.add("Billy Jean");
		list.add("No way jose");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));

		System.out.println("----------------");
					
		/* This test verifies that the void add(int index, E element) 
		 * method works */
	
		System.out.println("Testing Method #1");
		
		/* Adds to the middle of the list */
		list.add(2, "Brett Favre");
		System.out.println(list.get(2));
		/* Adds to the tail of the list */
		list.add(5, "John Madden");
		System.out.println(list.get(5));
		/* Adds to the head of the list */
		list.add(0, "Patriots");
		System.out.println(list.get(0));

		System.out.println("----------------");
		
		System.out.println("Testing Method #2");
		
		/* This test verifies that the contains(Object o) methods works correctly */
		System.out.println(list.contains("Brett Favre"));
		System.out.println(list.contains("Billy Bob"));
		System.out.println(list.contains("Johnny Rocketts"));
		System.out.println(list.contains("Billy Jean"));
		System.out.println(list.contains("No way jose"));
		System.out.println(list.contains("John Madden"));
		System.out.println(list.contains("Patriots"));

		System.out.println("-----------------");
		
		System.out.println("Testing Method #3");
		list.addFirst("John Elway");
		System.out.println(list.get(0));
		
		System.out.println("-----------------");

		System.out.println("Testing Method #4");
		list.addLast("Chad Mendes");
		System.out.println(list.get(7));
		
		System.out.println("-----------------");
		
		System.out.println("Testing Method #5");
		/* Testing removing from the head */
		list.remove("John Elway");
		list.remove("Patriots");
		
		/* Testing removing from the middle of the list */
		list.remove("John Madden");
		
		/* Testing removing from the end of the list */
		list.remove("Chad Mendes");
		
		System.out.println("-----------------");
		
		System.out.println("After removal of elements from the list ");
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		System.out.println("-----------------");
		
		System.out.println("Testing Method #6");
		/* Testing if it works by removing from the head */
		list.remove(0);
		
		/* Testing if it works by removing from the middle of the list */
		list.remove(1);
		
		/* Testing if it works by removing from the tail */
		list.remove(2);
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		System.out.println("------------------");
		
		System.out.println("Testing Method #7");
		
		System.out.println(list.size());
		
		System.out.println("------------------");	
		
		System.out.println("Testing Method #8");
		
		/* Testing if sets the head to the value */
		list.set(0, "Cookie Monster");
		
		/* Testing if it sets an element in the middle of the list to the value */
		list.set(3, "Cookie Monster");

		/* Testing if it sets the tail element of the list to the value */
		list.set(8, "Cookie Monster");
		
		/* Printing list to see changes */
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		System.out.println("---------------------");

		System.out.println("Testing Method #9");
		list.clear();
		
		System.out.println("-----------------------");
		
		/* Verifies that the list is cleared */
		System.out.println(list.size());
	}
}
