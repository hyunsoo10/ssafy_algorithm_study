package boj_큐빙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
	static int cnt;
	static char[][][] cube;
	static char[] colors = new char[] { 'w', 'y', 'r', 'o', 'g', 'b' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			cube = new char[6][3][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						cube[i][j][k] = colors[i];
					}
				}
			}
			// 초기화
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				String[] tmp = str[i].split("");
				command(tmp[0], tmp[1]);
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(cube[0][i][j]);
				}
				System.out.println();
			}
		}
	}

	static void method(int f, boolean dir) { 
		char[][] tmp = new char[3][3];
		char[] tmp2 = new char[3];
		if(f==U) {
			if (dir) {
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[U][2 - j][i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[B][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[B][0][i] = cube[L][0][i];
				}

				for(int i=0;i<3;i++) {
					cube[L][0][i] = cube[F][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[F][0][i] = cube[R][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[R][0][i] = tmp2[i] ;
				}
				
			} else {					
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[U][j][2 - i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[B][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[B][0][i] = cube[R][0][i];
				}

				for(int i=0;i<3;i++) {
					cube[R][0][i] = cube[F][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[F][0][i] = cube[L][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[L][0][i] = tmp2[i] ;
				}
				
			}
			cube[U] = tmp;
		}else if(f==D) {
			if (dir) {
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[D][2 - j][i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[B][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[B][2][i] = cube[R][2][i];
				}

				for(int i=0;i<3;i++) {
					cube[R][2][i] = cube[F][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[F][2][i] = cube[L][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[L][2][i] = tmp2[i] ;
				}
				
			} else {					
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[D][j][2 - i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[B][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[B][2][i] = cube[L][2][i];
				}

				for(int i=0;i<3;i++) {
					cube[L][2][i] = cube[F][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[F][2][i] = cube[R][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[R][2][i] = tmp2[i] ;
				}
				
				
			}
			cube[D] = tmp;
		}else if(f==F) {
			if (dir) {
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[F][2 - j][i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][2][i] = cube[L][2-i][2];
				}

				for(int i=0;i<3;i++) {
					cube[L][i][2] = cube[D][2][2-i];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][2][i] = cube[R][i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[R][i][0] = tmp2[i] ;
				}
				
			} else {					
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[F][j][2 - i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][2][2-i];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][2][i] = cube[R][i][0];
				}

				for(int i=0;i<3;i++) {
					cube[R][i][0] = cube[D][2][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][2][i] = cube[L][2-i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[L][i][2] = tmp2[i] ;
				}
				
				
			}
			cube[F] = tmp;
		}else if(f==B) {
			if (dir) {
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[B][2 - j][i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][0][2-i];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][0][i] = cube[R][i][2];
				}

				for(int i=0;i<3;i++) {
					cube[R][i][2] = cube[D][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][0][i] = cube[L][2-i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[L][i][0] = tmp2[i] ;
				}
				
			} else {					
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[B][j][2 - i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][0][i];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][0][i] = cube[L][2-i][0];
				}

				for(int i=0;i<3;i++) {
					cube[L][i][0] = cube[D][0][2-i];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][0][i] = cube[R][i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[R][i][2] = tmp2[i] ;
				}
				
				
			}
			cube[B] = tmp;
		}else if(f==L) {
			if (dir) {
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[L][2 - j][i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][i][0] = cube[B][2-i][2];
				}

				for(int i=0;i<3;i++) {
					cube[B][i][2] = cube[D][i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][i][2] = cube[F][2-i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[F][i][0] = tmp2[i] ;
				}
				
			} else {					
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[L][j][2 - i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][2-i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][i][0] = cube[F][i][0];
				}

				for(int i=0;i<3;i++) {
					cube[F][i][0] = cube[D][2-i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][i][2] = cube[B][i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[B][i][2] = tmp2[i] ;
				}
				
				
			}
			cube[L] = tmp;
		}else if(f==R) {
			if (dir) {
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[R][2 - j][i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][2-i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][i][2] = cube[F][i][2];
				}

				for(int i=0;i<3;i++) {
					cube[F][i][2] = cube[D][2-i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][i][0] = cube[B][i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[B][i][0] = tmp2[i] ;
				}
				
			} else {					
				for (int i = 0; i < 3; ++i) 
					for (int j = 0; j < 3; ++j) {
						tmp[i][j] = cube[R][j][2 - i];
					}
				for(int i=0;i<3;i++) {
					tmp2[i] = cube[U][i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[U][i][2] = cube[B][2-i][0];
				}

				for(int i=0;i<3;i++) {
					cube[B][i][0] = cube[D][i][0];
				}
				
				for(int i=0;i<3;i++) {
					cube[D][i][0] = cube[F][2-i][2];
				}
				
				for(int i=0;i<3;i++) {
					cube[F][i][2] = tmp2[i] ;
				}
				
				
			}
			cube[R] = tmp;
		}
	}

	static void command(String s, String dir) {
		boolean flag = true;
		if (dir.equals("-")) {
			flag = false;
		}

		switch (s) {
		case "U":
			method(U, flag);
			break;
		case "D":
			method(D, flag);
			break;
		case "F":
			method(F, flag);
			break;
		case "B":
			method(B, flag);
			break;
		case "L":
			method(L, flag);
			break;
		case "R":
			method(R, flag);
			break;
		}

	}
}