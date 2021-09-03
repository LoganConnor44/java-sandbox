package loganconnor44.katas;

public class MoveZerosToEnd {

    public int[] moveZeroes(int[] nums) {
        //create two pointers - commander and seeker
        //the commander will verify that the current item is not zero
            //if it is send out the seeker to find the next item that is not a zero and swap places
            //commander moves up to seeker
        
        for (int commander = 0; commander < nums.length; commander++) {
            if (nums[commander] == 0) {
                for (int seeker = commander + 1; seeker < nums.length; seeker++) {
                    if (nums[seeker] != 0) {
                        this.swap(commander, seeker, nums);
                        break;
                    }
                }
            }
        }

        return nums;
    }

    private void swap(int indexX, int indexY, int[] nums) {
        int temp = nums[indexX];
        nums[indexX] = nums[indexY];
        nums[indexY] = temp;
    }
}
