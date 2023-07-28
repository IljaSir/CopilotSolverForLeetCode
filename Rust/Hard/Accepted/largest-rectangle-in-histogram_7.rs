impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut stack: Vec<usize> = vec![];
        let mut ans = 0;
        let mut heights = heights;
        heights.push(0);
        for i in 0..heights.len() {
            while let Some(&top) = stack.last() {
                if heights[top] > heights[i] {
                    stack.pop();
                    let width = if let Some(&left) = stack.last() {
                        i - left - 1
                    } else {
                        i
                    };
                    ans = ans.max(width as i32 * heights[top]);
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        ans
    }
}