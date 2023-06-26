#include <windows.h>
int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, PSTR cmdLine, int iCmdShow)
{
    MessageBox(NULL, TEXT("Hello world"), TEXT("Hi"), MB_OK | MB_ICONINFORMATION);
    return 0;
}