package objectorientedprograms.Commercial;

public class QueueNode 
{
		public String data;
		public QueueNode next;	
		public QueueNode previous ;
		public QueueNode(String data , QueueNode next ,QueueNode previous) 
		{
			super();
			this.data = data;
			this.next = next;
			this.previous = previous ;
		}	
	}

