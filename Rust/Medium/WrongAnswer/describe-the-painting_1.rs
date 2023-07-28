impl Solution {
    pub fn split_painting(segments: Vec<Vec<i32>>) -> Vec<Vec<i64>> {
        
        let mut ans = vec![];
        let mut events = vec![];
        for seg in segments {
            events.push((seg[0], seg[2]));
            events.push((seg[1], -seg[2]));
        }
        events.sort();
        let mut last = 0;
        let mut last_x = 0;
        let mut last_color = 0;
        for event in events {
            if last_color > 0 {
                ans.push(vec![last_x as i64, event.0 as i64, last_color as i64]);
                last += event.0 - last_x;
            }
            last_x = event.0;
            if event.1 > 0 {
                last_color += event.1;
            } else {
                last_color -= event.1;
            }
        }
        ans
    }
}