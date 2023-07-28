impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut heights = heights;
        heights.push(0);
        let mut stack = vec![];
        let mut ans = 0;
        for (i, &h) in heights.iter().enumerate() {
            while let Some(&j) = stack.last() {
                if heights[j] < h {
                    break;
                }
                stack.pop();
                let left = if let Some(&k) = stack.last() {
                    k + 1
                } else {
                    0
                };
                ans = ans.max(heights[j] * (i - left) as i32);
            }
            stack.push(i);
        }
        ans
    }
}