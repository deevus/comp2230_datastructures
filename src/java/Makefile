OUTPUT_DIR=../../bin/java
CC=javac
CC_OPTS=-d $(OUTPUT_DIR)
SOURCES=*.java

all: build

build:
	mkdir -p $(OUTPUT_DIR) && $(CC) $(CC_OPTS) $(SOURCES)

clean:
	rm -rf $(OUTPUT_DIR)


