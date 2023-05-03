package br.com.Forum.mapper

interface IMapper<T, U> {
    fun map(t: T): U
}
