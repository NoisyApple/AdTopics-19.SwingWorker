# [Advanced Programming Topics] #19 SwingWorker

This is the **19th** project part of my Advanced Programming Topics course at Leon Institute of Thechnology :mortar_board::lion:.

## :dart:GOAL

Create a program with a GUI were it shows the funtionality of the `SwingWorker` class.

## :eyeglasses:BRIEF EXPLANATION

Java works with three main threads:

- **Current Thread:** this is the thread on which the main program's logic runs.
- **Event Dispatch Thread:** Every event handling functions executes here.
- **Worker Threads or Background Threads:** All time consuming tasks runs here.

So, sometimes when we execute a thread on a GUI program, the graphical interface blocks completely and therefore we are no longer able to use the elements in the interface until the executed thread stops. To prevent this to happen we can use a class named `SwingWorker`.

`SwingWorker` gives us the ability to run a task on a **Worker Thread**, which prevents the GUI to freeze, this way we can run other tasks while the **Worker Thread** runs our other tasks on background.

---

This program's GUI has two parts, the top panel which calculates the specified nth fibonacci value using a `SwingWorker`, and the bottom panel, which calculates a new fibonacci value based on the previous, this last not using `SwingWorker`.

Since the `SwingWorker` part uses a recursive algorithm, it will take a while until its done, so when it is processing the specified value we should be able to use the bottom part with no problem.

<p align="center">
<img src="./snapshots/Annotation 2020-05-26 173243.png"/>
</p>

Lets input a value that will take a while to produce a result:

<p align="center">
<img src="./snapshots/Annotation 2020-05-26 173514.png"/>
</p>

As we can see, when we press the **"Start"** button, the program starts to calculate the **45th fibonacci value**.

<p align="center">
<img src="./snapshots/Annotation 2020-05-26 173530.png"/>
</p>

Meanwhile we can press the **Next number** button and get a result in the bottom panel withou any GUI blocking.

<p align="center">
<img src="./snapshots/Annotation 2020-05-26 173540.png"/>
</p>

Finally, when the `SwingWorker` process is done, the expected value is shown in the top panel.
