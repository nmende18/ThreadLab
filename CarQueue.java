
import java.util.LinkedList;
import java.util.Queue;


public class CarQueue {
	private Queue<Integer> queue;
	
	public CarQueue() {
		this.queue = new LinkedList<>();
		for(int i = 0; i < 6; i++) {
			queue.add((int) (Math.random() * 4));
		}
		addToQueue();
	}
	
	public void addToQueue() {
		Runnable Queue = new Runnable(){

	@Override
	public void run() {
		
		try {
			while(true) {
				synchronized(queue) {
				queue.add((int) (Math.random() * 4));
				}
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		
		}

	}
	};
		Thread thread = new Thread(Queue);
		thread.start();
	}
	
	public synchronized Integer deleteQueue() {
		return queue.poll();
	}

}