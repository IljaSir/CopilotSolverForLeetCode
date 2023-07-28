impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut stack = Vec::new();
        let mut ans = 0;
        let mut heights = heights;
        heights.push(0);
        for i in 0..heights.len() {
            while !stack.is_empty() && heights[*stack.last().unwrap()] > heights[i] {
                let h = heights[stack.pop().unwrap()];
                let w = if stack.is_empty() { i } else { i - stack.last().unwrap() - 1 };
                ans = ans.max(h * w as i32);
            }
            stack.push(i);
        }
        ans
    }
}