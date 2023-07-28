impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events: Vec<Vec<i32>> = events;
        events.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut day = 1;
        let mut count = 0;
        let mut i = 0;
        let mut visited = vec![false; 100001];
        while i < events.len() && day <= events[events.len() - 1][1] {
            let mut j = i;
            while j < events.len() && events[j][1] == day {
                j += 1;
            }
            let mut k = j - 1;
            while k >= i {
                if !visited[events[k][0] as usize] {
                    visited[events[k][0] as usize] = true;
                    count += 1;
                    break;
                }
                k -= 1;
            }
            day += 1;
            i = j;
        }
        count
    }
}