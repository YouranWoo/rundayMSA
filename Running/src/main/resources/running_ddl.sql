-- Table: public.running

-- DROP TABLE IF EXISTS public.running;

CREATE TABLE IF NOT EXISTS public.running
(
    id bigint NOT NULL DEFAULT nextval('running_id_seq'::regclass),
    end_latitude real,
    end_longitude real,
    end_time timestamp without time zone,
    pause_end_time timestamp without time zone,
    pause_start_time timestamp without time zone,
    running_time timestamp without time zone,
    start_latitude real,
    start_longitude real,
    start_time timestamp without time zone,
    total_pause_time timestamp without time zone,
    user_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT running_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.running
    OWNER to runday;