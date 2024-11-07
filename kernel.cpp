extern "C" void kernel_main();

extern "C" void kernel_main() {
    // Your kernel code goes here
    // For example, clear the screen and print a message
    clear_screen();
    const char* message = "Welcome to my x86 OS!";
    print(message);

    while (true) {
        // Infinite loop
    }
}

// Additional functions such as clear_screen() and print()
void clear_screen() {
    const char* video_memory = (const char*)0xB8000; // VGA text mode buffer
    for (int i = 0; i < 80 * 25 * 2; i += 2) {
        video_memory[i] = ' ';      // Space character
        video_memory[i + 1] = 0x07; // Light gray on black
    }
}

void print(const char* str) {
    const char* video_memory = (const char*)0xB8000;
    for (int i = 0; str[i] != '\0'; i++) {
        video_memory[i * 2] = str[i]; // Character
        video_memory[i * 2 + 1] = 0x07; // Attribute byte (light gray on black)
    }
}