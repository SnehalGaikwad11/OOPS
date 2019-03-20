package objectorientedprograms.Commercial;

public class LinkedList 
{
		public Node head;
		public void insert(String words)
		{
			Node node1 = new Node(words, head);
			node1.data = words;
			node1.next = null;
			if(head == null)
			{
				head = node1;
			}
			else
			{
				Node node2 = head;
				while(node2.next!=null)
				{
					node2 = node2.next;
				}
				node2.next = node1;			
			}
		}
		public void show() 
		{
			Node node = head;
			while(node.next!=null)
			{
				System.out.print(node.data+ " --> ");
				node = node.next;
			}
			System.out.println(node.data);
		}
		public void remove(String search)
		{
			Node node = head ;
			Node temp = null;
			if(node != null && node.data == search)
			{
				head = node.next;
				return;
			}
			while(node != null && ((node.data).compareTo(search))!=0)
			{
				temp = node;
				node = node.next;
			}
			if(node == null)
				return;
			temp.next = node.next;
		}
		public void search(String search)
		{
			if(head == null)
				return;
			Node node = head;
			while(node.next!= null && (node.data).compareTo(search) != 0)
			{
				node = node.next;
			}
			if((node.data).compareTo(search) == 0)
			{
				System.out.println("Data is present in list\nAfter deletion : ");	
				remove(search);
			}		
		}
	}
