TARGET=Slot.jar

SRCDIR=src
SRC=SlotNumber.java SlotMachine.java SlotMachineApplet.java
CLASSESDIR=classes
CLASSES=$(SRC:.java=.class)
LIBDIR=lib

all: $(TARGET)

$(TARGET):$(patsubst %,$(CLASSESDIR)/%,$(CLASSES))
	jar cvfm $(TARGET) MANIFEST.MF -C classes . 

$(CLASSESDIR)/%.class:$(SRCDIR)/%.java
	javac -d classes -classpath classes $^

$(CLASSESDIR)/%.class:$(LIBDIR)/%.java
	javac -d classes -classpath classes $^

.PHONY: clean
clean:
	rm classes/* $(TARGET)

