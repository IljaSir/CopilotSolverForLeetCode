impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut a = (0, 0);
        let mut b = (0, 0);
        for n in nums {
            if a.0 == n {
                a.1 += 1;
            } else if b.0 == n {
                b.1 += 1;
            } else if a.1 == 0 {
                a = (n, 1);
            } else if b.1 == 0 {
                b = (n, 1);
            } else {
                a.1 -= 1;
                b.1 -= 1;
            }
        }
        let mut res = vec![];
        let mut count_a = 0;
        let mut count_b = 0;
        for n in nums {
            if n == a.0 {
                count_a += 1;
            } else if n == b.0 {
                count_b += 1;
            }
        }
        if count_a > nums.len() / 3 {
            res.push(a.0);
        }
        if count_b > nums.len() / 3 {
            res.push(b.0);
        }
        res
    }
}