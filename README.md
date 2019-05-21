# Mars hover

###The problem:
A team of robots is ready to explore Mars terrain.
The terrain to be explored is a retangle and must be explored in a such way that all cameras attached to each robot, together must get images of the  area to send back to Earth.

The position of each robot é represented by the combination of carthesian coordinates (x,y) and one letter, wich can be represented by one of four
orietations: NORTH, SOUTH, EAST and WEST. In order to simplify the navigation, the "mars" place to be explored was divided in many retangle areas.
One valid robot position woud be (0, 0, N), this means that the robot is located on the left down corner of the retangle, pointed to North.
To control each robot, NASA sends a simple string, that can contain letters ‘L’, ‘R’ and ‘M’. The letters ‘L’ and ‘R’ are 90 degrees rotation commands to left or right respectivelly. The letter ‘M’ is the command to send the robot one position forward.
For instance: The command "MML" telling to the robot go from eg.: (0,0,N) to (0,2,W)

###Requirements:
The terrain shoud be with 5x5 positions;
The robot start at position (0,0,N);
Should be possible to send a command to the robot respond with its actual position;
The robot cannot move outside the specified area;
The robot must not keep it's state;

###Testing:
Movement with rotarions to the right:
Input: curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
Output: (2, 0, S)

Movement to the left:
Input: curl -s --request POST http://localhost:8080/rest/mars/MML
Output: (0, 2, W)

Repeat it's position moving to the left:
Input: curl -s --request POST http://localhost:8080/rest/mars/MML
Output: (0, 2, W)

Invalid command:
Input: curl -s --request POST http://localhost:8080/rest/mars/AAA
Output: 400 Bad Request

Invalid position:
Input: curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
Output: 400 Bad Request
