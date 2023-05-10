A private static instance of the Semaphore class is declared, initialized with a permit count of 2. This means that up to two threads can concurrently access the resource.
The accessResource() method is defined, which handles the process of accessing the shared resource.
Within the method, the thread attempts to acquire a permit from the semaphore by calling semaphore.acquire(). If a permit is available, the thread proceeds to execute the critical section of code.
The thread prints its name and the current system time using System.currentTimeMillis().
The thread then simulates some work by sleeping for 100 milliseconds.
After completing its task, the thread releases the permit by calling semaphore.release().
If the thread is interrupted during the execution of accessResource(), it prints the stack trace of the InterruptedException.
