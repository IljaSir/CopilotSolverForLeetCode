impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 {
            return false;
        }
        let part = sum / 3;
        let mut count = 0;
        let mut temp = 0;
        for i in arr {
            temp += i;
            if temp == part {
                count += 1;
                temp = 0;
            }
        }
        count == 3
    }
}