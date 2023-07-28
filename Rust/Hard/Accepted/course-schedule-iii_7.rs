impl Solution {
    pub fn schedule_course(courses: Vec<Vec<i32>>) -> i32 {
        
        let mut courses = courses;
        courses.sort_by_key(|v| v[1]);
        let mut time = 0;
        let mut heap = std::collections::BinaryHeap::new();
        for v in courses {
            if time + v[0] <= v[1] {
                time += v[0];
                heap.push(v[0]);
            } else if !heap.is_empty() && heap.peek().unwrap() > &v[0] {
                time = time - heap.peek().unwrap() + v[0];
                heap.pop();
                heap.push(v[0]);
            }
        }
        heap.len() as i32
    }
}