1. Clear all existence of `apertium*`, `lt-*`, `hfst` from the machine. Use `which` to find them (usually in `/usr/local/bin`)

2. This will install all of the Apertium packages, but we will replace half of them later:
	```bash
	apt install apertium-dev cg3 hfst  # Ubuntu
	```

3. Go to `lttoolbox-java`

	```bash
	sh autogen.sh
	make
	make  # Might require running second time if the first one fails
	```

	You should be able to run:
	```bash
	> lt-proc-j -v
	org.apertium.lttoolbox.LTProc version 3.4.2
	```

	<!-- Create symlinks:
	```bash
	ln -s /usr/local/bin/apertium-destxt-j /usr/local/bin/apertium-destxt
	ln -s /usr/local/bin/apertium-pretransfer-j /usr/local/bin/apertium-pretransfer
	ln -s /usr/local/bin/apertium-interchunk-j /usr/local/bin/apertium-interchunk
	ln -s /usr/local/bin/apertium-retxt-j /usr/local/bin/apertium-retxt
	ln -s /usr/local/bin/apertium-j /usr/local/bin/apertium
	ln -s /usr/local/bin/apertium-tagger-j /usr/local/bin/apertium-tagger
	ln -s /usr/local/bin/apertium-pack-j /usr/local/bin/apertium-pack
	ln -s /usr/local/bin/apertium-transfer-j /usr/local/bin/apertium-transfer
	ln -s /usr/local/bin/apertium-postchunk-j /usr/local/bin/apertium-postchunk
	ln -s /usr/local/bin/apertium-preprocess-transfer-bytecode-j /usr/local/bin/apertium-preprocess-transfer-bytecode

	ln -s /usr/local/bin/lt-comp-j /usr/local/bin/lt-comp
	ln -s /usr/local/bin/lt-expand-j /usr/local/bin/lt-expand
	ln -s /usr/local/bin/lt-proc-j /usr/local/bin/lt-proc
	ln -s /usr/local/bin/lt-trim-j /usr/local/bin/lt-trim
	ln -s /usr/local/bin/lt-validate-j /usr/local/bin/lt-validate
	ln -s /usr/local/bin/lt-print-j /usr/local/bin/lt-print
	```

	Check with `ls -l` -->

4. Go to `lttoolbox`

	```bash
	git checkout tags/v3.4.2 -b v3.4.2
	sh autogen.sh
	make
	```

	You should be able to run:
	```bash
	> lt-proc -v
	lt-proc version 3.4.2
	```

	Check with `ls -l /usr/local/bin/`

5. Go to `apertium-kir`

	Edit `configure.ac`:
	```diff
	- PKG_CHECK_MODULES(APERTIUM, apertium >= 3.6.1)
	+ PKG_CHECK_MODULES(APERTIUM, apertium >= 3.5.0)

	- PKG_CHECK_MODULES(LTTOOLBOX, lttoolbox >= 3.5.1)
	+ PKG_CHECK_MODULES(LTTOOLBOX, lttoolbox >= 3.4.2)

	- PKG_CHECK_MODULES(CG3, cg3 >= 1.3.0)

	PKG_CHECK_MODULES(HFST, hfst >= 3.15.0)
	```

	```bash
	sh autogen.sh
	make  # can take 10+ minutes
	```

6. In IntelliJ IDEA, create a new project and add `lttoolbox-java/dist/lttoolbox.jar` as a dependency. Check the box to copy it to `lib`

7. Copy `apertium-kir/kir.automorf.bin` to `kotlin_test/src/main/resources/`


> [!NOTE]
> Currectly ther are symbolic links to `lttoolbox.jar` and `kir.automorf.bin` everywhere in the project


### CLI Usage:

```bash
echo "боюнча" | java -jar lttoolbox.jar lt-proc apertium-kir/kir.automorf.bin
```
