impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut ret: Vec<i32> = Vec::new();
        let mut index: i32 = 0;
        for num in &nums {
            let mut i = index + 1;
            for n in &nums[(index + 1) as usize..] {
                if num + n == target {
                    ret.push(index);
                    ret.push(i);
                    return ret;
                }
                i += 1;
            }
            index += 1;
        }
        ret
    }
}