# GIT 협업 FLOW

1. GIT 폴더로 이동
- GIT repository를 모아둔 폴더로 이동

2. repository 로컬로 받아오기 
- `git clone "https://github.com/hyunsoo10/ssafy_algorithm_study.git"`

3. git config user email or name이 등록 안돼있을 경우

- `git config --global user.email "your github email"`
- `git config --global user.name "your github name"`

4. 브랜치 생성
- `git checkout -b "your branch name"`

5. 본인의 브랜치로 이동
- git checkout "your branch name"

6. 로컬에서 remote로 파일 업로드
- `git add .`

7. 커밋
- `git commit -m "commit message"`

8. 본인 브랜치로 push
- `git push origin "your branch name"`

9. pull request
- push된 repository로 가서 New pull request

10. confirm 하면 master branch로 merge