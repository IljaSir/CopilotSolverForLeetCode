impl Solution {
    pub fn find_min_difference(time_points: Vec<String>) -> i32 {
        

        let mut time_points = time_points.iter().map(|s| {
            let mut time = s.split(":");
            let hour = time.next().unwrap().parse::<i32>().unwrap();
            let minute = time.next().unwrap().parse::<i32>().unwrap();
            hour * 60 + minute
        }).collect::<Vec<i32>>();
        time_points.sort();
        let mut min = time_points[0] + 24 * 60 - time_points[time_points.len() - 1];
        for i in 0..time_points.len() - 1 {
            min = min.min(time_points[i + 1] - time_points[i]);
        }
        min
    }
}