package Summer.ArarysHashMap;

public class RobotBoundByCircle
{
    enum Directions {
        North,
        East,
        West,
        South
    }
    public boolean isRobotBounded(String ins)
    {
        Directions directions= Directions.North;
        int x =0, y=0;

        for (char ch : ins.toCharArray())
        {
            if (ch=='G')
            {
                switch (directions)
                {
                    case North :
                        y++;
                        break;
                    case East:
                        x++;
                        break;
                    case West:
                        x--;
                        break;
                    case South:
                        y--;
                        break;
                }
            }
            else if (ch=='L')
            {
                switch (directions)
                {
                    case North :
                        directions = Directions.West;
                        break;
                    case East:
                        directions = Directions.North;
                        break;
                    case West:
                        directions = Directions.South;
                        break;
                    case South:
                        directions = Directions.East;
                        break;
                }
            }
            else if (ch=='R')
            {
                switch (directions)
                {
                    case North:
                        directions = Directions.East;
                        break;
                    case East:
                        directions = Directions.South;
                        break;
                    case West:
                        directions = Directions.North;
                        break;
                    case South:
                        directions = Directions.West;
                        break;
                }
            }
        }
        if (x==0 && y==0)
        {
            return true;
        }
        else if (directions==Directions.North)
        {
            return false;
        }
        return true;
    }
}
