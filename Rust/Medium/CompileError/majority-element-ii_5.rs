impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut cnt1 = 0;
        let mut cnt2 = 0;
        let mut v1 = 0;
        let mut v2 = 0;
        for n in nums {
            if n == v1 {
                cnt1 += 1;
            } else if n == v2 {
                cnt2 += 1;
            } else if cnt1 == 0 {
                v1 = n;
                cnt1 = 1;
            } else if cnt2 == 0 {
                v2 = n;
                cnt2 = 1;
            } else {
                cnt1 -= 1;
                cnt2 -= 1;
            }
        }
        let mut ans = Vec::new();
        let mut cnt1 = 0;
        let mut cnt2 = 0;
        for n in nums {
            if n == v1 {
                cnt1 += 1;
            } else if n == v2 {
                cnt2 += 1;
            }
        }
        if cnt1 > nums.len() / 3 {
            ans.push(v1);
        }
        if cnt2 > nums.len() / 3 {
            ans.push(v2);
        }
        ans
    }
}