impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut ans = vec![];
        let mut cur = 1;
        while cur <= 9 {
            let mut num = cur;
            let mut next = cur + 1;
            while next <= 9 {
                num = num * 10 + next;
                if num >= low && num <= high {
                    ans.push(num);
                }
                next += 1;
            }
            cur += 1;
        }
        ans.sort();
        ans
    }
}