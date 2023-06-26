#include <windows.h>
#include <stdlib.h>
#include <string.h>
#include <tchar.h>
#include <stdio.h>
LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM); // định nghĩa hàm thủ tục cửa sổ
int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, PSTR cmdLine, int iCmdShow)
{
    // Định nghĩa lớp cửa sổ
    WNDCLASS wndclass;                          // Khai báo lớp cửa sổ
    static TCHAR szAppName[] = TEXT("Ví dụ 1"); // Tên ứng dụng
    wndclass.style = CS_HREDRAW | CS_VREDRAW;   // Kiểu cửa sổ
    wndclass.lpfnWndProc = WndProc;             // Thủ tục cửa sổ (thủ tục xử lý các thông điệp)
    wndclass.cbClsExtra = 0;                    // Không cần thông tin thêm cho cửa sổ
    wndclass.cbWndExtra = 0;
    wndclass.hInstance = hInstance;                               // Chỉ số của cửa số
    wndclass.hIcon = LoadIcon(hInstance, szAppName);              // Tải ICON cho cửa sổ
    wndclass.hCursor = LoadCursor(NULL, IDC_ARROW);               // Tải chuột
    wndclass.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH); // màu nền của cửa sổ
    wndclass.lpszMenuName = NULL;                                 // menu
    wndclass.lpszClassName = szAppName;                           // Tên lóp ứng dụng, szAppName có kiểu dữ liêu TCHAR được khai báo static
    // Đăng kí lớp cửa sổ
    if (!RegisterClass(&wndclass))
    {
        MessageBox(NULL, TEXT("This program requires Windows NT!"), szAppName, MB_ICONERROR);
        return 0;
    }
    // Tạo cửa sổ
    //  handle của cửa sổ
    HWND hWnd = CreateWindow(szAppName,                       // tên lớp cửa sổ
                             TEXT("About Box Demo Program "), // tiêu đề
                             WS_OVERLAPPEDWINDOW,             // kiểu cửa sổ
                             CW_USEDEFAULT, CW_USEDEFAULT,    // tọa độ bên trái cửa sổ
                             CW_USEDEFAULT, CW_USEDEFAULT,    // kích thước
                             NULL, NULL, hInstance, NULL);    // chỉ số cửa sổ cha, menu, chỉ số cửa sổ hiện tại, con trỏ đến thông tin phụ
    // Hiển thị cửa sổ
    ShowWindow(hWnd, iCmdShow);
    UpdateWindow(hWnd);

    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0)) // lấy ra 1 thông điệp từ hàng đợi
    {
        TranslateMessage(&msg); // Chuyển 1 thông điệp phím ảo sang thông điệp ký tự, sẽ được đưa vào hàng đợi
        // thông điệp và được lấy ra ở lần lấy tiếp theo
        DispatchMessage(&msg); // truyền thông điệp vào thủ tục cửa sổ tương ứng để xử lý
    }
    return (int)msg.wParam;
}
// đăng kí thủ tục cửa sổ
LRESULT CALLBACK WndProc(HWND hWnd, UINT uMsg, WPARAM wParam, LPARAM lParam)
{
    RECT rect, textrect; // 1 hình chữ nhật khai báo vị trí
    HDC hdc;             // Handle to Device Context định nghĩ thành phần đồ họa
    PAINTSTRUCT ps;      // cho phép vẽ hình và style
    TCHAR greeting[] = TEXT("Program C for Windows!");
    switch (uMsg)
    {
    // case WM_CREATE:
    //     MessageBox(NULL, TEXT("Hello world"), TEXT("Hi"), MB_OK | MB_ICONINFORMATION);
    //     break;
    // case WM_SIZE:
    //     printf("%s", "size\n");
    //     break;
    // case WM_SIZING:
    //     printf("%s ", "sizing");
    //     break;
    case WM_PAINT:
        hdc = BeginPaint(hWnd, &ps); //bắt đầu công việc vẽ nội dung cửa sổ
        GetClientRect(hWnd, &rect); //lấy kích thước của miền thao tác
        SetTextColor(hdc, RGB(0xFF, 0x00, 0x00));
        SetBkMode(hdc, TRANSPARENT);
        rect.top = rect.bottom / 2 - textrect.bottom / 2;
        DrawText(hdc, greeting, -1, // tự tính toán số lượng kí tự
                 &rect, DT_CENTER   // căn giữa theo chiều ngang
                            | DT_EXPANDTABS);
        EndPaint(hWnd, &ps);
        break;
    // case WM_CLOSE:
    //     MessageBox(NULL, TEXT("Hello world"), TEXT("Hi"), MB_OK | MB_ICONINFORMATION);
    //     break;
    case WM_DESTROY:
        PostQuitMessage(0); // Đưa thông điệp kết thúc chương trình vào hàng đợi thông điệp
        break;
    }
    return DefWindowProc(hWnd, uMsg, wParam, lParam); // Thực hiện công việc xử lý mặc định với 1 thông điệp
}