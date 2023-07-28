impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let mut res1 = Solution::closest_divisors_helper(num+1);
        let mut res2 = Solution::closest_divisors_helper(num+2);
        if res1[1]-res1[0] < res2[1]-res2[0] {
            res2
        } else {
            res1
        }
    }
    fn closest_divisors_helper(num: i32) -> Vec<i32> {
        let mut res = vec![];
        let mut i = 1;
        while i*i <= num {
            if num % i == 0 {
                res = vec![i, num/i];
            }
            i += 1;
        }
        res
    }
}