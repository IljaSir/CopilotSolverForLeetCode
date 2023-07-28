impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut stack: Vec<(i32, i32)> = vec![];
        let mut max_area = 0;
        for (i, &h) in heights.iter().enumerate() {
            let mut start = i as i32;
            while !stack.is_empty() && stack.last().unwrap().1 > h {
                let (s, h) = stack.pop().unwrap();
                max_area = max_area.max((i as i32 - s) * h);
                start = s;
            }
            stack.push((start, h));
        }
        while !stack.is_empty() {
            let (s, h) = stack.pop().unwrap();
            max_area = max_area.max((heights.len() as i32 - s) * h);
        }
        max_area
    }
}